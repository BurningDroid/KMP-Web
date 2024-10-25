package com.aaron.kmp.web.data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore

class ChefRepo(
    private val firestore: FirebaseFirestore = Firebase.firestore
) {
    fun getChefList() {
        firestore.collection("chefs")
    }
}