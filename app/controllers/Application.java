package controllers;

import models.Person;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.command.CommandFactory;
import org.drools.io.ResourceFactory;
import org.drools.runtime.ExecutionResults;
import org.drools.runtime.StatelessKnowledgeSession;
import play.exceptions.CompilationException;
import play.mvc.Controller;

import java.util.Arrays;

public class Application extends Controller {

    public static void index() {


        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newFileResource("drl/rules.drl"), ResourceType.DRL);
        if (kbuilder.hasErrors()) {
            throw new CompilationException(kbuilder.getErrors().toString());
        }

        kbuilder.getKnowledgePackages();

        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

        StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
//        ksession.addEventListener(new DebugAgendaEventListener());
//        ksession.addEventListener(new DebugWorkingMemoryEventListener());

        ExecutionResults bresults =
                ksession.execute(CommandFactory.newBatchExecution( Arrays.asList(
                        CommandFactory.newInsertElements(Person.findAll())
                )));

        render(bresults);
    }

}