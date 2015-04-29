package sorcer.core.context.model.srv;

import sorcer.core.context.model.ent.Entry;
import sorcer.core.context.ApplicationDescription;
import sorcer.service.*;
import sorcer.service.modeling.Model;
import sorcer.service.modeling.Variability;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Mike Sobolewski on 4/14/15.
 */
public class SrvEntry extends Entry<Object> implements Variability<Object>, Arg, Evaluation<Object>,
        Comparable<Object>, Reactive<Object>, Serializable {

    private static Logger logger = LoggerFactory.getLogger(SrvEntry.class.getName());

    protected final String name;

    Type type = Type.PAR;;

    protected String selectedFidelity;

    // srv fidelities
    protected Map<String, Object> fidelities;

    public SrvEntry(String name) {
        super(name);
        this.name = name;
    }

    public SrvEntry(String name, String path, Type type) {
        super(name);
        this.name = name;
        this.type = type;
    }

    public SrvEntry(String path, Object value) {
        super(path, value);
        this.name = path;
    }

    public SrvEntry(String name, Object value, String path) {
        super(path, value);
        this.name = name;
    }

    public SrvEntry(String name, Object value, String path, Type type) {
        this(name, value, path);
        this.type = type;
    }

    public SrvEntry(String name, Model model, String path) {
        super(path, model);
        this.name = name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public ApplicationDescription getDescription() {
        return null;
    }

    @Override
    public Class<?> getValueType() {
        return null;
    }

    @Override
    public ArgSet getArgs() {
        return null;
    }

    @Override
    public void addArgs(ArgSet set) throws EvaluationException {

    }

    @Override
    public Object getArg(String varName) throws ArgException {
        return null;
    }

    @Override
    public boolean isValueCurrent() {
        return false;
    }

    @Override
    public void valueChanged(Object obj) throws EvaluationException, RemoteException {

    }

    @Override
    public void valueChanged() throws EvaluationException {

    }

    @Override
    public Object getPerturbedValue(String varName) throws EvaluationException, RemoteException {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getPath() {
        return _1;
    }

    @Override
    public double getPerturbation() {
        return 0;
    }
}
