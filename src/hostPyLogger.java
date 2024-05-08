import jep.Interpreter;
import jep.JepConfig;
import jep.JepException;
import jep.SubInterpreter;
import jep.python.MemoryManager;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class hostPyLogger {

    void jepLogger(String inStr, String inErr) {
        System.out.println("the inputs were: \n" + inStr + "\n" + inErr);

        Interpreter jepInt = null;
        MemoryManager memMan = null;
        //
        try {
            // 2 - Instantiate JepConfig.
            JepConfig jepConfig = new JepConfig().addIncludePaths(".").addSharedModules("pathlib")
                    .addIncludePaths("py_logger");
            System.out.println("jep Configured");
            //What about memory manager?
            memMan = new MemoryManager();
            jepInt = new SubInterpreter(jepConfig);

            jepInt.eval("import jep_log_writer as lg");
            System.out.println("eval'd the py file");

            jepInt.set("s_str", inStr);
            jepInt.set("msg", inErr);
            System.out.println("set the variable");

            jepInt.eval("lg.logger_(s_str, msg)");
            System.out.println("ran the py");

        } catch (JepException r) {
            System.out.println("JepException in logging?\n: " + r.getMessage());
            r.printStackTrace();
        } finally {
            System.out.println("finally");
            if (jepInt != null) {
                try {
                    memMan.cleanupWeakReferences();
                    jepInt.close();
                } catch (JepException s) {
                    System.out.println("JepException in jep.close()?\n: " + s.getMessage());
                    s.printStackTrace();
                }
            }
        }
    }
}