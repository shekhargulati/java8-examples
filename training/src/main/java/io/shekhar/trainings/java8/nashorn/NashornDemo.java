package io.shekhar.trainings.java8.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by shekhargulati on 01/11/15.
 */
public class NashornDemo {

    public static void main(String[] args) {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine nashorn = engineManager.getEngineByName("nashorn");
        nashorn.put("name", "shekhar");
        nashorn.put("age", 31);
        try {
            nashorn.eval("var user = {'name':name,'age':age}");
            System.out.println(nashorn.get("user"));
        } catch (ScriptException e) {
            System.err.println(e);
        }
    }
}
