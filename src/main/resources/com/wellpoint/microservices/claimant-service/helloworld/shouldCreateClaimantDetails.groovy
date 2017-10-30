package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	priority 1
	name("should first post a request")
    request {
        method 'POST'
		url '/claimant'
		headers {
			contentType(applicationJson())
		}
		body ([
 				claimantId: '119bbacd-9c03-4044-867f-4c26e8f715f6',
            	firstName: 'Arthur',
            	lastName: 'Portas',
            	email: 'Arthur@test.com',
            	age: 45
        ])
    }

    response {
        status 200
    }
}