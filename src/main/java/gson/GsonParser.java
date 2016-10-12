package gson;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonParser {
	public static void main(String[] args) throws Exception {
		fromJson();
//		toJson();
	}

	private static void toJson() {
		Evaluation evaluation = new Evaluation();
		evaluation.setOperator("=");
		evaluation.setType("number");
		evaluation.setValue("10");

		RuleCondition ruleCondition = new RuleCondition();
		ruleCondition.setEvaluation(evaluation);
		ruleCondition.setField("DaysSinceLastActivity__c");

		RuleConditions ruleConditions = new RuleConditions();
		ruleConditions.setRuleCondition(Arrays.asList(ruleCondition));

		Rule rule = new Rule();
		rule.setAction("Talk to management");
		rule.setDesc("Rule to check inactive opportunities");
		rule.setId("1");
		rule.setRuleConditions(ruleConditions);

		Rules rules = new Rules();
		rules.setRule(Arrays.asList(rule));

		Gson gson = new GsonBuilder().create();
		System.out.println("Json from object " + gson.toJson(rules));
	}

	private static void fromJson() throws Exception {
		FileInputStream fis = new FileInputStream("/home/sam/tmp/rules.json");
		Gson gson = new GsonBuilder().create();
		RulesWrapper rulesWrapper = gson.fromJson(new InputStreamReader(fis), RulesWrapper.class);
		System.out.println("rules size : " + rulesWrapper.getRules().getRule().size());
		List<Rule> ruleList = rulesWrapper.getRules().getRule();
		for (Rule rule : ruleList) {
			System.out.println("rule : " + rule);
			RuleConditions ruleConditions = rule.getRuleConditions();
			System.out.println("ruleConditions " + ruleConditions);
		}
	}
}
