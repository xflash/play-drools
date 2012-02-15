package controllers;

import models.Drools;
import models.Person;
import models.Pet;
import models.PetType;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.command.Command;
import org.drools.command.CommandFactory;
import org.drools.common.DefaultFactHandle;
import org.drools.event.rule.DebugAgendaEventListener;
import org.drools.event.rule.DebugWorkingMemoryEventListener;
import org.drools.runtime.ExecutionResults;
import org.drools.runtime.StatelessKnowledgeSession;
import org.drools.runtime.help.BatchExecutionHelper;
import play.mvc.Controller;

import java.util.Arrays;

public class Application extends Controller {

    public static void index() {


        final Person person = new Person("homer");
        person.cat("titi");

        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(Drools.knowledgePackages);

        StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
//        ksession.addEventListener(new DebugAgendaEventListener());
//        ksession.addEventListener(new DebugWorkingMemoryEventListener());

        ExecutionResults bresults =
                ksession.execute(CommandFactory.newBatchExecution( Arrays.asList(
                        CommandFactory.newInsert(person, "stilton")
                )));
        Object stilton = bresults.getValue( "stilton" );

//        BatchExecutionHelper.newJSonMarshaller().





//        knowledgeBase.addKnowledgePackages(builder.getKnowledgePackages());
//
//        dsession = knowledgeBase.newStatefulKnowledgeSession();
//        return dsession;

        render(bresults);
    }

}