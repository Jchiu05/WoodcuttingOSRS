package osrs;

import org.powerbot.script.rt4.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;

public abstract class Tasks extends ClientAccessor { //methods for superclasses only


    public Tasks(ClientContext ctx) {
        super(ctx);
    }

    public abstract boolean activate();

    public abstract void execute();

}
