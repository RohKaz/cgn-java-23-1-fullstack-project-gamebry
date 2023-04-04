import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import {Link, Tooltip, Zoom} from '@mui/material';
import {Game} from "../model/Game";

type GameCardProps = {
    game: Game;
}

export default function GameCard(props: GameCardProps) {

    return (
        <Tooltip TransitionComponent={Zoom} title={"Go to " + props.game.title} followCursor={true}>
            <Link href={"/games/" + props.game.id} sx={{textDecoration: "none"}}>
                <Card sx={{
                    width: 180,
                    minHeight: 280,
                    height: "auto",
                    margin: 0.5,
                    border: 2,
                    borderColor: "40414b",
                    borderRadius: 2,
                    backgroundColor: "#40414b",
                }}>
                    <CardMedia
                        component="img"
                        src={props.game.cover}
                        alt="Here should be a cover image of the game"
                        sx={{
                            maxHeight: 220,
                            width: 180,
                        }}
                    />
                    <CardContent sx={{
                        color: "white",
                    }}>
                        {props.game.title}
                    </CardContent>
                </Card>
            </Link>
        </Tooltip>
    );
}