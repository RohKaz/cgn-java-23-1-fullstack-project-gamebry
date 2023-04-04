import {Game} from "../model/Game";
import GameCard from "./GameCard";
import {Box} from "@mui/material";
import Typography from "@mui/material/Typography";

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
            padding: 1
        }}>
            <Typography sx={{
                fontSize: 35,
                textAlign: "left",
                color: "white",
            }}>
                New and upcoming releases
            </Typography>
            {games}
        </Box>
    )
}