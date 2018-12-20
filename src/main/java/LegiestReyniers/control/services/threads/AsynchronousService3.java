package LegiestReyniers.control.services.threads;

import LegiestReyniers.support.AddDataThread;
import LegiestReyniers.support.DataAnalysisThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class AsynchronousService3 {

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private ApplicationContext applicationContext;

    public void executeAsynchronously() {
        AddDataThread myThread = applicationContext.getBean(AddDataThread.class);
        taskExecutor.execute(myThread);

    }


}
