package sorcer.eol.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sorcer.test.ProjectContext;
import org.sorcer.test.SorcerTestRunner;
import sorcer.arithmetic.provider.impl.AdderImpl;
import sorcer.service.*;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static sorcer.co.operator.inEnt;
import static sorcer.eo.operator.*;

/**
 * @author Mike Sobolewski
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@RunWith(SorcerTestRunner.class)
@ProjectContext("examples/eol")
public class LocalExertionTasks {
	private final static Logger logger = Logger.getLogger(LocalExertionTasks.class.getName());
	
	@Test
	public void exertTask() throws Exception  {

		Task t5 = srv("t5", sig("add", AdderImpl.class),
				cxt("add", inEnt("arg/x1", 20.0), inEnt("arg/x2", 80.0), result("result/y")));

		Exertion out = exert(t5);
		Context cxt = context(out);
		logger.info("out context: " + cxt);
		logger.info("context @ arg/x1: " + get(cxt, "arg/x1"));
		logger.info("context @ arg/x2: " + value(cxt, "arg/x2"));
		logger.info("context @ result/y: " + value(cxt, "result/y"));

		assertEquals(100.0, value(cxt, "result/y"));

	}
	
	@Test
	public void valgetInPathsueTask() throws SignatureException, ExertionException, ContextException  {

		Task t5 = task("t5", sig("add", AdderImpl.class),
				cxt("add", inEnt("arg/x1", 20.0), inEnt("arg/x2", 80.0), result("result/y")));

		Object out = value(t5);
		logger.info("out value: " + out);
		assertEquals(100.0, out);
	}

}
	
	