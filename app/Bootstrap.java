import play.Logger;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

/**
 */
@OnApplicationStart
public class Bootstrap extends Job {

    @Override
    public void doJob() throws Exception {
        Logger.info("Bootstrap jobs");

        Fixtures.loadModels("initial-data.yml");

        //TODO Precompile Drools DRL file

    }
}
