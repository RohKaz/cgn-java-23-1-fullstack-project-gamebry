import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import {CardActionArea} from '@mui/material';
import {Game} from "../model/Game";

type GameCardProps = {
    game: Game;
}
export default function GameCard(props: GameCardProps) {

    return (
        <Card sx={{maxWidth: 345}}>
            <CardActionArea>
                <CardMedia
                    component="img"
                    height="140"
                    image="/static/images/cards/contemplative-reptile.jpg"
                    alt="An image of the game"
                />
                <CardContent>
                    <Typography gutterBottom variant="h5" component="div">
                        {props.game.gameTitle}
                    </Typography>
                    <Typography variant="body2" color="text.secondary">
                        {props.game.gameDescription}
                    </Typography>
                </CardContent>
            </CardActionArea>
        </Card>
    );
}