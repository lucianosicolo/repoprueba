package domainapp.webapp.application.fixture.scenarios;

import org.apache.isis.extensions.fixtures.fixturescripts.FixtureScript;
import org.apache.isis.extensions.fixtures.legacy.teardown.TeardownFixtureAbstract2;
import org.springframework.stereotype.Component;

import domainapp.modules.simple.dom.impl.SimpleObject;
import domainapp.modules.simple.fixture.SimpleObject_persona;

public class DomainAppDemo extends FixtureScript {

    @Override
    protected void execute(final ExecutionContext ec) {
        ec.executeChild(this, new TeardownFixtureAbstract2() {
            @Override
            protected void execute(final ExecutionContext executionContext) {
                deleteFrom(SimpleObject.class);
            }
        });
        ec.executeChild(this, new SimpleObject_persona.PersistAll());
    }

}
