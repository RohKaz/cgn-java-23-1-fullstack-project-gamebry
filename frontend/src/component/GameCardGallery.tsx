import {Game} from "../model/Game";
import GameCard from "./GameCard";
import "./GameCardGallery.css"


type GameCardGalleryProps = {
    games: Game[];
}

export default function GameCardGallery(props: GameCardGalleryProps) {

    const games = props.games.map((game) => {
        return (
            <GameCard game={game} key={game.gameId}/>)
    })
    return (
        <div className={"game-card-gallery"}>
            {games}
        </div>
    )
}