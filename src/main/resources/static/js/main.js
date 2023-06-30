const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");

sign_up_btn.addEventListener('click', () =>{
  container.classList.add("sign-up-mode");
});

sign_in_btn.addEventListener('click', () =>{
  container.classList.remove("sign-up-mode");
});

// add hovered class to selected list item
let list = document.querySelectorAll(".navigation li");

function activeLink() {
  list.forEach((item) => {
    item.classList.remove("hovered");
  });
  this.classList.add("hovered");
}

list.forEach((item) => item.addEventListener("mouseover", activeLink));

// Menu Toggle
let toggle = document.querySelector(".toggle");
let navigation = document.querySelector(".navigation");
let main = document.querySelector(".main");

toggle.onclick = function () {
  navigation.classList.toggle("active");
  main.classList.toggle("active");
};

function login() {
  var userName = document.getElementById("userName").value;
  var password = document.getElementById("password").value;

  var users = [{
      "userName" : "apsy",
      "password" : "apsy"
  },
  {
      "userName" : "perscholas",
      "password" : "perscholas"
  }];

  var loginSucess = false;
  for(let i = 0; i < users.length; i++) {
      let obj = users[i];
      if(userName == obj.userName && password == obj.password) {
          document.getElementById("loginForm").action = 'account.html'
          document.getElementById("loginForm").submit();
          loginSucess = true;
      }
  }

  if (loginSucess) {
    console.log("Successfully logged in to the application");
  } else {
    const errorMessage = document.getElementById("errorMessage");
    errorMessage.textContent = "Invalid username or password.";
  }
}
