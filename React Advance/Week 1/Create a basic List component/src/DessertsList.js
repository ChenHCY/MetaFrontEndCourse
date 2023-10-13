function DessertsList(props) {
  // Implement the component here.
  /*从父文件提取desserst array, 然后创建一个新的array 里面保存小于500 calories的dessert */
  const lowDessert = props.data.filter((item) => item.calories <= 500);
  /*把dessert按照calories 递增顺序 排列 */
  const sortDessert = lowDessert.sort((a, b) => a.calories - b.calories);

  return (
    <ul>{
      sortDessert.map(
        (dessert) =>  <li>
         {dessert.name} - {dessert.calories} cal 
       </li> 
      )
    }
    </ul>
  );
}

export default DessertsList;
