import {useEffect, useState} from "react";
import {GameCardDetailsModel} from "../model/GameCardDetailsModel";
import {useParams} from "react-router-dom";
import axios from "axios";
import {Box, Collapse, Divider, List, ListItemButton, ListItemIcon, ListItemText} from "@mui/material";
import Typography from "@mui/material/Typography";
import AccessTime from "@mui/icons-material/AccessTime";
import {Category, ExpandLess, ExpandMore, Info, SupervisedUserCircle} from "@mui/icons-material";
import AppBarHeader from "./AppBarHeader";


export default function GameCardDetailsPage() {

    const params = useParams();
    const id: string | undefined = params.id;

    const [details, setDetails] = useState<GameCardDetailsModel | undefined>();
    const [open, setOpen] = useState(true);
    const handleClick = () => {
        setOpen(!open);
    }

    const requestURL: string = "/api/games/" + id

    useEffect(() => {
        axios
            .get(requestURL)
            .then((response) => {
                setDetails(response.data);
                console.log(details);
            }).catch((error) => console.error(error));
    }, [details, requestURL]);

    if (!details) {
        return <h1>Loading data...</h1>;
    }

    if (!details.releaseDate) {
        details.releaseDate = "TBA";
    }

    const genre = details.genres.map((genre, index) => (
        <ListItemText key={genre.id} primary={`${genre.name}${index !== details.genres.length - 1 ? ', ' : ''}`}/>
    ));

    const publisher = details.publishers.map((publisher, index) => (
        <ListItemText key={publisher.id}
                      primary={`${publisher.name}${index !== details.publishers.length - 1 ? ', ' : ''}`}/>
    ));

    return (
        <><AppBarHeader/><Box sx={{
            display: "flex",
            flexDirection: "",
            height: "fit-content",
            justifyContent: "left",
            textAlign: "left",
            padding: 6,
            backgroundColor: "#1f345c",
            alignContent: "left"
        }}>
            <Typography sx={{
                fontSize: 25,
                color: "white",
                textAlign: "left",
            }}>
                <div className={"game-title"}>{details.title}</div>
                <Box component="img" sx={{
                    imageRendering: "pixelated",
                    height: 250,
                    width: 320,
                    display: "flex",
                    marginTop: 2
                }}
                     alt={"Here should be a cover image of the game"}
                     src={details.cover}/>
                <List sx={{maxWidth: 400, height: "auto", color: "white", marginTop: 2}}
                      component={"nav"}>
                    <ListItemButton onClick={handleClick}>
                        <ListItemIcon>
                            <Info/>
                        </ListItemIcon>
                        <ListItemText primary={"Game information"}/>
                        {open ? <ExpandLess/> : <ExpandMore/>}
                    </ListItemButton>
                    <Divider/>
                    <Collapse in={open} timeout={"auto"} unmountOnExit>
                        <List component={"div"} disablePadding>
                            <ListItemButton>
                                <ListItemIcon>
                                    <AccessTime/>
                                </ListItemIcon>
                                <ListItemText primary={"Release date: " + details.releaseDate}/>
                            </ListItemButton>
                            <ListItemButton>
                                <ListItemIcon>
                                    <SupervisedUserCircle/>
                                </ListItemIcon>
                                <ListItemText primary={"Publisher: "}/>
                                {publisher}
                            </ListItemButton>
                            <ListItemButton>
                                <ListItemIcon>
                                    <Category/>
                                </ListItemIcon>
                                <ListItemText primary={"Genres: "}/>
                                {genre}
                            </ListItemButton>
                        </List>
                    </Collapse>
                </List>
                <Typography sx={{fontWeight: "bold", fontSize: 14, marginTop: 2}}>
                    About the game:
                </Typography>
                <Divider orientation={"horizontal"} sx={{border: 1, borderStyle: "", color: "black"}}/>
                <Typography sx={{fontSize: 10, color: "white", fontWeight: "bold", textAlign: "start",}}>
                    <p>{details.description_raw}</p>
                </Typography>
            </Typography>
        </Box></>
    )
}
