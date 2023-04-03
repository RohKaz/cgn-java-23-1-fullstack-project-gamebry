import React, {useEffect, useState} from 'react';
import {GameCardModel} from "./model/GameCardModel";
import axios from "axios";
import GameCardGallery from "./component/GameCardGallery";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import GameCardDetailsPage from "./component/GameCardDetailsPage";
import AppHeader from "./component/AppHeader";

function App() {

    const [game, setGame] = useState<GameCardModel[]>([]);

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
            <header>
                <AppHeader/>
            </header>
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
