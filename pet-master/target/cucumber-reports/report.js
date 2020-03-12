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
  ],
  "tags": [
    {
      "name": "@test_1"
    }
  ]
});
formatter.scenario({
  "name": "Create a new pet",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@test_1"
    }
  ]
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
});