import React, {useEffect, useState} from 'react';
import {GameCardModel} from "./model/GameCardModel";
import axios from "axios";
import GameCardGallery from "./component/GameCardGallery";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import GameCardDetailsPage from "./component/GameCardDetailsPage";
import SignUpPage from "./component/SignUpPage";
import SignInPage from "./component/SignInPage";

function App() {

    const [game, setGame] = useState<GameCardModel[]>([]);

    axios.interceptors.response.use(function (response) {
        return response;
    }, function (error) {
        if (error.response.status === 401) {
            window.location.href = "/sign-in";
        }
        return Promise.reject(error);
    });

    function getNewAndUpcomingGames() {
        axios.get("/api/games/new")
            .then(response => {
                setGame(response.data);
            })
            .catch(console.error)
    }

    useEffect(() => {
        getNewAndUpcomingGames()
    }, []);

    return (
        <div className={"App"}>
            <BrowserRouter>
                <Routes>
                    <Route path={"/"} element={<SignUpPage/>}/>
                    <Route path={"/sign-in"} element={<SignInPage/>}/>
                    <Route path={"/home"} element={<GameCardGallery games={game}/>}/>
                    <Route path={"/games/:id"} element={<GameCardDetailsPage/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
