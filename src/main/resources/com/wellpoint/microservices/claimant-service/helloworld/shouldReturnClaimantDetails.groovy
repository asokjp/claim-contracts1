package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	priority 2
    request {
        method 'GET'
        urlPath '/claimant', {
            queryParameters {
                parameter 'lastName': $(consumer(regex('[a-zA-z]+')), producer('Portas'))
            }
        }
    }

    response {
        status 200
        body([
               claimantId: $(
						consumer('119bbacd-9c03-4044-867f-4c26e8f715f6'),
						producer(regex(nonEmpty()))),
                firstName: 'Arthur',
                lastName: 'Portas',
                email: $(
						consumer('Arthur@test.com'),
						producer(regex(email()))),
                age: $(anyNumber())
        ])
        headers {
            header('Content-Type': value(
                    producer(regex('application/json.*')),
                    consumer('application/json')
            ))
        }
    }
}
