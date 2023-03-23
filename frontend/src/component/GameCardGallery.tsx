import {Game} from "../model/Game";
import GameCard from "./GameCard";
import "./GameCardGallery.css"
import {Box} from "@mui/material";

type GameCardGalleryProps = {
    games: Game[];
}

export default function GameCardGallery(props: GameCardGalleryProps) {

    const games = props.games.map((game) => {
        return (
            <GameCard game={game} key={game.gameId}/>
        )
    })
    return (
        <Box sx={{
            display: "flex",
            flexDirection: "row",
            flexWrap: "wrap",
            justifyContent: "center",
            alignItems: "center",
            alignContent: "center",
            border: 1,
            borderColor: "black",
            backgroundColor: "#1f345c",


        }}>

            {games}

        </Box>
    )
}