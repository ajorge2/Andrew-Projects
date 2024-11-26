// The default for visibility is "visible", but you can change it
document.getElementById('login-form').style.display = 'visible';
document.getElementById('register-form').style.display = 'none';

// Demo for toggling visibility
function showRegisterForm() {
    document.getElementById('login-form').style.display = 'none';
    document.getElementById('register-form').style.display = 'block';
}

function showLoginForm() {
    document.getElementById('register-form').style.display = 'none';
    document.getElementById('login-form').style.display = 'block';
}

// Check if user is already logged in
//window.onload = function() {
//     if(localStorage.getItem('isLoggedIn') === 'true') {
//         alert('You are already logged in!');
//         window.location.href = 'shopper.html'; // Redirect to dashboard page
//     }
// };

// Listen for when someone presses the submit button in the login form
document.getElementById('login').addEventListener('submit', function(event) {
    // This prevents the default behavior for form submission and lets us
    // specify custom behavior
    event.preventDefault(); 
    
    /* What follows is custom functionality! */
    // Get the entered username and password
    var username = document.getElementById('login-username').value;
    var password = document.getElementById('login-password').value;
    
    // Check if username and password match the stored values
    var storedUsername = localStorage.getItem('username');
    var storedPassword = localStorage.getItem('password');

    // Don't forget === in JS! That's a small interview question sometimes.
    if (username === storedUsername && password === storedPassword) {
        // Store login status in local storage
        localStorage.setItem('isLoggedIn', 'true');
        alert('Login successful!');
        // Redirect to shopper page
        window.location.href = "shopper.html"; 
    } else {
        alert('Invalid username or password. Please try again.');
    }
});

// When we register, we want to set the local storage values
document.getElementById('register').addEventListener('submit', function(event) {
    event.preventDefault();
    
    // Get the entered username and password
    var username = document.getElementById('register-username').value;
    var password = document.getElementById('register-password').value;
    
    // Store username and password in local storage
    localStorage.setItem('username', username);
    localStorage.setItem('password', password);
    
    alert('Registration successful! You can now login.');
    showLoginForm();
});