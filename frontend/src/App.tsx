import React, {useEffect, useState} from 'react';
import {Game} from "./model/Game";
import axios from "axios";
import GameCardGallery from "./component/GameCardGallery";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import GameCardDetailsPage from "./component/GameCardDetailsPage";

function App() {

    const [game, setGame] = useState<Game[]>([]);

    function getNewAndUpcomingGames() {
        axios.get("/api/games/new")
            .then(response => {
                setGame(response.data);
            })
            .catch(console.error);
    }

    useEffect(() => {
        getNewAndUpcomingGames()
    }, []);

    return (
        <div className={"App"}>
            <BrowserRouter>
                <Routes>
                    <Route path={"/"} element={<GameCardGallery games={game}/>}/>
                    <Route path={"/games/:id"} element={<GameCardDetailsPage/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
