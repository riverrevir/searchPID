import logo from './logo.svg';
import React, {useState} from 'react';
import './App.css';

function App() {
  const [대분류, set대분류] = useState('')
  const [중분류, set중분류] = useState('')
  const [소분류, set소분류] = useState('')

  const handleClickSearch = () => {
  console.log('@@@@@@@@');
  console.log(대분류);
  console.log(중분류);
  console.log(소분류);

  const data = {
  method: 'GET',
  headers: {
  'Content-Type': 'application/json; charset=UTF-8',
  }
  };
  fetch('http://39.113.21.160:8080/api/ship/category', data).then(res => {
  console.log("성공");
  console.log(res.body);
  }).catch(rej => {
    console.log("실패");
    console.log(rej);
  })
}
  return (
    <div className="App">
      <div className='main_img'>
        <img src="logo192.png"></img>
        <h1>PID 도면 관리 시스템</h1>
      </div>
      <hr></hr>
      <div className='search'>
        <form className='search_1'>
          <input type="text" id='pid' placeholder='프로젝트ID'></input>
          <input type="submit" id='pid_s' value="검색"></input>
        </form>

        <form className='search_2'>
          <input type="text" id='first' placeholder='대분류' value={대분류} onChange={e=>set대분류(e.target.value)}></input>
          <input type="text" id='second' placeholder='중분류' value={중분류} onChange={e=>set중분류(e.target.value)}></input>
          <input type="text" id='third' placeholder='소분류'value={소분류} onChange={e=>set소분류(e.target.value)}></input>
          <input type="button" id='item_s' value="검색" onClick={handleClickSearch}></input>
        </form>
      </div>
      <hr></hr>
    </div>
  );
}

export default App;
