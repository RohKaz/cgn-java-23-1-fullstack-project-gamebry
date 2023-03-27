import {useEffect, useState} from "react";
import {Game} from "../model/Game";
import {useParams} from "react-router-dom";
import axios from "axios";
import {Box, Divider} from "@mui/material";
import Typography from "@mui/material/Typography";


export default function GameCardDetailsPage() {

    const params = useParams();
    const id: string | undefined = params.gameId;

    const [details, setDetails] = useState<Game | undefined>();

    const requestURL: string = "/api/games/" + id

    useEffect(() => {
        axios
            .get(requestURL)
            .then((response) => {
                setDetails(response.data);
                console.log(details);
            }).catch((error) => console.error(error));
    }, [requestURL]);

    if (!details) {
        return <h1>NO DATA</h1>;
    }

    return (
        <Box sx={{
            display: "flex",
            flexDirection: "",
            height: "auto",
            justifyContent: "left",
            textAlign: "left",
            padding: 6,
            backgroundColor: "#1f345c",
            //283561
            //1f2a4d
        }}>
            <Typography sx={{
                fontSize: 40,
                color: "white",
                textAlign: "left",
            }}>
                <div className={"game-title"}>{details.gameTitle}</div>
                <p>
                    <Box component="img" sx={{
                        imageRendering: "pixelated",
                        height: 200,
                        width: 300,
                        display: "flex",
                    }}
                         alt={"Here should be a cover image of the game"}
                         src={"http://1.bp.blogspot.com/-yjm45McKLL4/UH3VFZiKweI/AAAAAAAABaQ/mpeVscC0GiA/s1600/Skyrim+-+Cover.jpg"}
                    />
                </p>
                <Typography sx={{fontWeight: "bold"}}>
                    About the game:
                </Typography>
                <Divider orientation={"horizontal"} sx={{border: 1, borderStyle: "", color: "black"}}/>
                <Typography sx={{fontSize: 10, color: "white", fontWeight: "bold", textAlign: "start",}}>
                    <p>{details.gameDescription}</p>
                </Typography>
            </Typography>
        </Box>
    )
}
