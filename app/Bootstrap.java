import models.Drools;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import play.Logger;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

/**
 */
@OnApplicationStart
public class Bootstrap extends Job {

    @Override
    public void doJob() throws Exception {

        Logger.info("Drools build");

        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add( ResourceFactory.newFileResource("drl/rules.drl"), ResourceType.DRL );
//        kbuilder.add( ResourceFactory.newClassPathResource("licenseApplication.drl", getClass()), ResourceType.DRL );
        if ( kbuilder.hasErrors() ) {
//            System.err.println( builder.getErrors().toString() );
            Logger.error(kbuilder.getErrors().toString());
        }

        Drools.knowledgePackages = kbuilder.getKnowledgePackages();


//        kbuilder.
//        kbase.addKnowledgePackages( kbuilder.getKnowledgePackages() );

    }
}
