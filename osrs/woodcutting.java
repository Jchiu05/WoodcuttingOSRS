package osrs;


import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;
import osrs.tasks.Drop;
import osrs.tasks.woodcut;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Script.Manifest(name = "Woodcutting", description = "Woodcutting Bot", properties = "client = 4; author = Jordan; topic = 999  ")

public class woodcutting extends PollingScript<ClientContext>{
    List<Tasks> tasksList = new ArrayList<Tasks>();

    @Override
    public void start(){
        tasksList.add(new Drop(ctx));
        tasksList.add(new woodcut(ctx));
    }


    @Override
    public void poll() {
        for(Tasks task : tasksList){
            if (task.activate()){
                task.execute();
                break;
            }
        }
    }
}
