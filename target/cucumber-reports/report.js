$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:PetStore.feature");
formatter.feature({
  "name": "Create Pet Store",
  "description": "  As an employe of the pet store\n  I Want to create a new pet",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Create a new pet",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Enter name \u0027\u003cname\u003e\u0027",
  "keyword": "Given "
});
formatter.step({
  "name": "Do post request",
  "keyword": "When "
});
formatter.step({
  "name": "Status for \u0027\u003cresult\u003e\u0027",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "name",
        "result"
      ]
    },
    {
      "cells": [
        "ironman",
        "200"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Create a new pet",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Enter name \u0027ironman\u0027",
  "keyword": "Given "
});
formatter.match({
  "location": "PetStoreStepDefinitions.given_name(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Do post request",
  "keyword": "When "
});
formatter.match({
  "location": "PetStoreStepDefinitions.post_requst()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status for \u0027200\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "PetStoreStepDefinitions.assertSingleResult(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Delete an pet",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Enter name \u0027\u003cname\u003e\u0027",
  "keyword": "Given "
});
formatter.step({
  "name": "Do delete request",
  "keyword": "When "
});
formatter.step({
  "name": "Status for \u0027\u003cresult\u003e\u0027",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "name",
        "result"
      ]
    },
    {
      "cells": [
        "spiderman",
        "200"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Delete an pet",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Enter name \u0027spiderman\u0027",
  "keyword": "Given "
});
formatter.match({
  "location": "PetStoreStepDefinitions.given_name(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Do delete request",
  "keyword": "When "
});
formatter.match({
  "location": "PetStoreStepDefinitions.delete_request()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status for \u0027200\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "PetStoreStepDefinitions.assertSingleResult(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Placing an order",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Enter name \u0027\u003cname\u003e\u0027",
  "keyword": "Given "
});
formatter.step({
  "name": "Do place order request",
  "keyword": "When "
});
formatter.step({
  "name": "Status for \u0027\u003cresult\u003e\u0027",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "name",
        "result"
      ]
    },
    {
      "cells": [
        "blackpanter",
        "200"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Placing an order",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Enter name \u0027blackpanter\u0027",
  "keyword": "Given "
});
formatter.match({
  "location": "PetStoreStepDefinitions.given_name(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Do place order request",
  "keyword": "When "
});
formatter.match({
  "location": "PetStoreStepDefinitions.place_order_request()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status for \u0027200\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "PetStoreStepDefinitions.assertSingleResult(int)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected:\u003c200\u003e but was:\u003c500\u003e\n\tat org.junit.Assert.fail(Assert.java:89)\n\tat org.junit.Assert.failNotEquals(Assert.java:835)\n\tat org.junit.Assert.assertEquals(Assert.java:647)\n\tat org.junit.Assert.assertEquals(Assert.java:633)\n\tat PetStoreStepDefinitions.assertSingleResult(PetStoreStepDefinitions.java:113)\n\tat ✽.Status for \u0027200\u0027(classpath:PetStore.feature:28)\n",
  "status": "failed"
});
});