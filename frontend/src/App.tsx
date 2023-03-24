import React, {useEffect, useState} from 'react';
import './App.css';
import {Game} from "./model/Game";
import axios from "axios";
import GameCardGallery from "./component/GameCardGallery";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import GameCardDetailsPage from "./component/GameCardDetailsPage";
import {Slide} from "@mui/material";


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
            <BrowserRouter>
                <Slide>
                    <Routes>
                        <Route path={"/"} element={<GameCardGallery games={game}/>}/>
                        <Route path={"/games/:gameId"} element={<GameCardDetailsPage/>}/>
                    </Routes>
                </Slide>
            </BrowserRouter>
        </div>
    );
}

export default App;
