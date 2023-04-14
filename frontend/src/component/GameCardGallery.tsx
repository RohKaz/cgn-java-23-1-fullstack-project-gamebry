import {GameCardModel} from "../model/GameCardModel";
import GameCard from "./GameCard";
import {Box} from "@mui/material";
import Typography from "@mui/material/Typography";
import useAuth from "../hooks/useAuth";
import AppBarHeader from "./AppBarHeader";
import axios from "axios";

type GameCardGalleryProps = {
    games: GameCardModel[];
}

export default function GameCardGallery(props: GameCardGalleryProps) {

    const user = useAuth(true);
    const games = props.games.map((game) => {
        return (
            <GameCard game={game} key={game.id}/>
        )
    })
    axios.interceptors.response.use(function (response) {
        return response;
    }, function (error) {
        if (error.response.status === 401) {
            alert("You are not authorized to view this page. Please sign in.")
            window.location.href = "/sign-in";
        }
        return Promise.reject(error);
    });

    return (
        <><AppBarHeader/><Box sx={{
            display: "flex",
            minHeight: "fit-content",
            maxHeight: "100%",
            flexDirection: "row",
            flexWrap: "wrap",
            justifyContent: "center",
            alignItems: "flex-start",
            alignContent: "center",
            border: 1,
            borderColor: "black",
            backgroundColor: "#1f345c",
            textAlign: "left",
            padding: 2
        }}>
            <Typography sx={{
                fontSize: 30,
                textAlign: "left",
                color: "white",
            }}>
                New and upcoming releases
            </Typography>
            {games}
        </Box></>
    )
}