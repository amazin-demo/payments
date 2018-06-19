package amazin.payments.web;

import amazin.payments.domain.repository.PaymentRepository;
import au.com.dius.pact.provider.junit.IgnoreNoPactsToVerify;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.RestPactRunner;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.target.MockMvcTarget;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(RestPactRunner.class)
@Provider("payments")
@IgnoreNoPactsToVerify
@PactBroker(host = "${pactbroker.host:localhost}", port = "${pactbroker.port:80}")
public class PaymentsWebServicePactTest {

    @TestTarget
    public final MockMvcTarget target = new MockMvcTarget();

    @Mock
    private PaymentRepository repositoryMock;

    @Before
    public void initTarget() {
        MockitoAnnotations.initMocks(this);
        target.setControllers(new PaymentsWebService(repositoryMock));
    }


}
