import {GameCardModel} from "../model/GameCardModel";
import GameCard from "./GameCard";
import {Box} from "@mui/material";
import Typography from "@mui/material/Typography";

type GameCardGalleryProps = {
    games: GameCardModel[];
}

export default function GameCardGallery(props: GameCardGalleryProps) {

    const games = props.games.map((game) => {
        return (
            <GameCard game={game} key={game.id}/>
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
            padding: 5
        }}>
            <Typography sx={{
                fontSize: 30,
                textAlign: "left",
                color: "white",
            }}>
                New and upcoming releases
            </Typography>
            {games}
        </Box>
    )
}