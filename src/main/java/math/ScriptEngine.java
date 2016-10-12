package math;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptEngine {
	public static void main(String[] args) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        javax.script.ScriptEngine engine = mgr.getEngineByName("JavaScript");
//        String foo = "0.42323>0.41211212";
        String foo = "0.42323>0.41211212";
        if ((boolean) engine.eval(foo)) {
        	System.out.println("Returning boolean");
        } else {
        	System.out.println(engine.eval(foo).getClass().getName());
        }
	}
}
