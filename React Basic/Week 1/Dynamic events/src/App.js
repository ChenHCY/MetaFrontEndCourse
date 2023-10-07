function App() {
  const handleClick = () => {
    /* Math.random() 是随机一个生成 0 - 1的小数， *3 扩大三倍 */
    let randomNum = Math.floor(Math.random() * 3) + 1;
    console.log(randomNum);
    /*弹出对话框的函数，它会在用户的浏览器中显示一个包含文本"type a number"的输入框 */
    let userInput = prompt("type a number");
    /*警告框（alert）函数。该警告框将两个变量的值显示在消息中 */
    alert(`Computer number: ${randomNum}, Your guess: ${userInput}`);
  }
  
  return (
    <div>
      <h1>Task: Add a button and handle a click event</h1>
      <button onClick={handleClick}>Guess the number between 1 and 3</button>
    </div>
  );
}

export default App;
