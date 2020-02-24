package com.fortnightfellows.granny.api_wrapper.models

class Ingredient() {

    constructor(name: String, amount: String) : this() {
        this.name = name
        this.amount = amount
    }

    var name: String? = null
    var amount: String? = null
}