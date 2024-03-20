package api.config.configuration;

import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config;

@LoadPolicy(Config.LoadType.MERGE)
@Sources({"classpath:api.properties"})
public interface BaseConfig extends Config {
    String url();
    String userId();
}
