import { useState, useEffect } from "react";

/*
 * Q22 - Infinite loop fix
 *
 * (a) WHAT IS WRONG:
 *     useEffect was called WITHOUT a dependency array. Without it, the effect runs
 *     after EVERY render. Inside it, setUsers(...) updates state, which triggers a
 *     re-render, which runs the effect again -> fetch -> setState -> render ...
 *     an infinite loop of network requests.
 *
 * (b) FIX:
 *     Pass an empty dependency array [] so the effect runs only ONCE, after the
 *     first render (on mount).
 *
 * (c) Added a "loading" state that shows 'Loading...' while the fetch is in progress.
 */
function UserList() {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch("/api/users")
      .then((res) => res.json())
      .then((data) => {
        setUsers(data);
        setLoading(false);
      })
      .catch(() => setLoading(false));
  }, []); // <-- FIX: empty dependency array => run once on mount

  if (loading) {
    return <p>Loading...</p>;
  }

  return (
    <ul>
      {users.map((u) => (
        <li key={u.id}>{u.name}</li>
      ))}
    </ul>
  );
}

export default UserList;
