package com.example.myrecipe_kotlin_mvvm_json;

public class LearnMVVM {
}

/* Model
Definition: Represents the data and business logic of the application.
It encapsulates the data that the app uses and the operations that can be performed on that data.

Responsibilities:
Defines the structure of the data (like data classes).
Handles data retrieval and storage (e.g., making network calls, interacting with a database).
Contains business logic that manipulates the data.

Ex: data class User(val id: Int, val name: String, val email: String)
*/


/* ViewModel
Definition:
Acts as a bridge between the UI (View) and the Model.
It is responsible for preparing and managing the data for the UI, ensuring that the UI remains updated when the data changes.

Responsibilities:
Holds UI-related data in a lifecycle-conscious way, allowing data to survive configuration changes (like screen rotations).
Exposes data to the UI through LiveData or StateFlow, which notifies the UI when data changes.
Handles user interactions and communicates with the Model to fetch or update data.

Ex: class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    fun loadUser(userId: Int) {
        // Fetch user from the repository and post the value to _user
    }
}

*/
