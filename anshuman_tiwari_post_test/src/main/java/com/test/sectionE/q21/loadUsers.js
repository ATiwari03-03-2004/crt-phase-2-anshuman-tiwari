// Q21 - async function that fetches /api/users and renders names or an error.

async function loadUsers() {
  const list = document.getElementById("user-list");
  const errorEl = document.getElementById("error");

  // clear any previous output
  list.innerHTML = "";
  errorEl.textContent = "";

  try {
    const response = await fetch("/api/users");

    if (!response.ok) {
      // server responded with a non-2xx status
      errorEl.textContent = "Failed to load users (status " + response.status + ")";
      return;
    }

    const users = await response.json();

    // render each user's name into the <ul id="user-list">
    users.forEach((user) => {
      const li = document.createElement("li");
      li.textContent = user.name;
      list.appendChild(li);
    });
  } catch (err) {
    // network / parsing error
    errorEl.textContent = "Error loading users: " + err.message;
  }
}

// Optionally run on page load:
// document.addEventListener("DOMContentLoaded", loadUsers);
