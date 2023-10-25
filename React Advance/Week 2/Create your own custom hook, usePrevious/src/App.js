import { useState, useEffect, useRef } from "react";

const usePrevious = (val) => {
  /* 使用useRef来创建一个ref对象，该对象在组件的整个生命周期内保持不变。 */
  const ref = useRef(); //创建了一个ref对象，该对象在每次渲染时不会重新创
  
  useEffect(() => {
    //ref.current是ref对象的属性，用于存储和访问val的当前值
    ref.current = val;  // 将 val 的当前值存储在 ref 对象的 .current 属性中。
  }, [val]);
}


export default function App() {
  const [day, setDay] = useState("Monday");
  const prevDay = usePrevious(day);
  
  const getNextDay = () => {
    if (day === "Monday") {
      setDay("Tuesday")
    } else if (day === "Tuesday") {
      setDay("Wednesday")
    } else if (day === "Wednesday") {
      setDay("Thursday")
    } else if (day === "Thursday") {
      setDay("Friday")
    } else if (day === "Friday") {
      setDay("Monday")
    }
  }


  return (
    <div style={{padding: "40px"}}>
      <h1>
        Today is: {day}<br />
        {
          prevDay && (
            <span>Previous work day was: {prevDay}</span>
          )
        }
      </h1>
      <button onClick={getNextDay}>
        Get next day
      </button>
    </div>
  );
}