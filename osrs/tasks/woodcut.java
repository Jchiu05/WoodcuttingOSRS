package osrs.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

import osrs.Tasks;

import java.util.concurrent.Callable;

public class woodcut extends Tasks{ // subclass extended to tasks

    final  static int Tree_IDS [] = {1276,1278};

    public woodcut(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
       return ctx.players.local().animation() == -1 && ctx.inventory.select().count()<28;

    }



    @Override
    public void execute() {
        GameObject Tree = ctx.objects.select().id(Tree_IDS).nearest().poll();
        Tree.interact("Chop Down");

        Condition.wait(new Callable<Boolean>() {  //stops the spam clicking
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().animation()!= -1;
            }
        }, 200, 10);
    }


}