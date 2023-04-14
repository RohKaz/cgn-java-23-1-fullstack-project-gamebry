import {GameCardModel} from "../model/GameCardModel";
import GameCard from "./GameCard";
import {Box} from "@mui/material";
import Typography from "@mui/material/Typography";
import useAuth from "../hooks/useAuth";
import AppBarHeader from "./AppBarHeader";

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