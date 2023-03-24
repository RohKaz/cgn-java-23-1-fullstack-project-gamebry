import {useEffect, useState} from "react";
import {Game} from "../model/Game";
import {useParams} from "react-router-dom";
import axios from "axios";


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
        <body className={"game-detail-body"}>
        <div>
            <h1>{details.gameTitle}</h1>
            <h6>{details.gameDescription}</h6>
        </div>
        </body>
    )
}
