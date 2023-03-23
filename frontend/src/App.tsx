import React, {useEffect, useState} from 'react';
import './App.css';
import {Game} from "./model/Game";
import axios from "axios";
import GameCardGallery from "./component/GameCardGallery";


function App() {

    const [game, setGame] = useState<Game[]>([]);

    function getGames() {
        axios.get("/api/games")
            .then(response => {
                setGame(response.data);
            })
            .catch(console.error);

    }

    useEffect(() => {
        getGames()
    }, []);


    return (
        <div className="App">


        <GameCardGallery games={game}/>

        </div>
    );
}

export default App;
