package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;
import osrs.Tasks;

import java.util.concurrent.Callable;

public class Drop extends Tasks{

    final static int Woods = 1511;

    public Drop(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.count()>27;
    }

    @Override
    public void execute() {
        for (Item Logs : ctx.inventory.select().id(Woods)){
            final int startAmount = ctx.inventory.select().id(Woods).count();
            Logs.interact("Drop", "Logs");

            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return ctx.inventory.select().id(Woods).count() !=startAmount;

                }
            }, 25, 20);
        }

    }
}
