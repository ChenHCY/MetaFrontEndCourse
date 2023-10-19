import "./App.css";
import { useState } from "react";
import { validateEmail } from "./utils";

const PasswordErrorMessage = () => {
  return (
    <p className="FieldError">Password should have at least 8 characters</p>
  );
};

function App() {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState({
    value: "",
    isTouched: false,
  });
  const [role, setRole] = useState("role");

  //检查function
  const getIsFormValid = () => {
    // Implement this function
    //如果名字的输出为空，或者邮箱不符合格式，或者密码的长度小于8 ==> 输出false
    if (firstName === "" || lastName === "" || !validateEmail(email) || password.length < 8) {
      return false;
    }

    //如果role没有任何改变，也输出false
    if (role === "role") {
      return false;
    }

    return true;
  };

  const clearForm = () => {
    // Implement this function
    // 清空所以输入
    setFirstName("");
    setLastName("");
    setEmail("");
    setPassword({
      value: "",
      isTouched: false
    });
    setRole("role");
  };

  const handleSubmit = (e) => {
    e.preventDefault(); // 暂时阻止提交，检查所有输入项是否符合要求
    if (getIsFormValid()) {
       alert("Account created!");
    }
    clearForm();
  };


  const handlePassword = (e) => {
    const inputPassword = e.target.value;
    setPassword((currItem) => ({
      value: inputPassword,
      isTouched: currItem.isTouched || inputPassword.length > 0,
    }));
  }

  return (
    <div className="App">
      <form onSubmit={handleSubmit}>
        
        <fieldset>
          <h2>Sign Up</h2>
          
          <div className="Field">
            <label>
              First name <sup>*</sup>
            </label>
            <input
              onChange={(e) => { 
               setFirstName(e.target.value); 
              }}
              placeholder="First name"
            />
          </div>
          
          <div className="Field">
            <label>Last name</label>
            <input
              onChange= {(e) => {
                setLastName(e.target.name);
              }}
              placeholder="Last name"
            />
          </div>
          
          <div className="Field">
            <label>
              Email address <sup>*</sup>
            </label>
            <input
              onChange={(e) => {
                setEmail(e.target.value);
              }}
              placeholder="Email address"
            />
          </div>

          <div className="Field">
            <label>
              Password <sup>*</sup>
            </label>
            <input
              type="password"
              value={password.value}
              onChange={handlePassword}
              placeholder="Password"
            />
            {password.isTouched && password.value.length < 8 && (
              <PasswordErrorMessage />
            )}
          </div>
          
          <div className="Field"> 
            <label> 
             Role <sup>*</sup> 
            </label>
            
           <select value={role} onChange={(e) => setRole(e.target.value)}> 
             <option value="role">Role</option> 
             <option value="individual">Individual</option> 
             <option value="business">Business</option> 
           </select> 
         </div> 

          <button type="submit" disabled={!getIsFormValid()}>
            Create account
          </button>

        </fieldset>
      </form>
    </div>
  );
}

export default App;
