package com.github.rohkaz.gamecardmodel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GameCardDetailsModelTest {
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void test() throws JsonProcessingException {
        String text = """
                {
                    "id": 906547,
                    "slug": "hogwarts-legacy",
                    "name": "Hogwarts Legacy",
                    "name_original": "Hogwarts Legacy",
                    "description": "<p>Hogwarts Legacy is an immersive, open-world action RPG set in the world first introduced in the Harry Potter books. Now you can take control of the action and be at the center of your own adventure in the wizarding world. Embark on a journey through familiar and new locations as you explore and discover fantastic beasts, customize your character and craft potions, master spell casting, upgrade talents, and become the wizard you want to be.</p>\\n<p>Experience Hogwarts in the 1800s. Your character is a student who holds the key to an ancient secret that threatens to tear the wizarding world apart. You have received a late acceptance to the Hogwarts School of Witchcraft and Wizardry and soon discover that you are no ordinary student: you possess an unusual ability to perceive and master Ancient Magic. Only you can decide if you will protect this secret for the good of all, or yield to the temptation of more sinister magic.</p>\\n<p>Discover the feeling of living at Hogwarts as you make allies, battle Dark wizards, and ultimately decide the fate of the wizarding world. Your legacy is what you make of it.</p>",
                    "metacritic": 85,
                    "metacritic_platforms": [
                        {
                            "metascore": 84,
                            "url": "https://www.metacritic.com/game/playstation-5/hogwarts-legacy",
                            "platform": {
                                "platform": 187,
                                "name": "PlayStation 5",
                                "slug": "playstation5"
                            }
                        },
                        {
                            "metascore": 83,
                            "url": "https://www.metacritic.com/game/pc/hogwarts-legacy",
                            "platform": {
                                "platform": 4,
                                "name": "PC",
                                "slug": "pc"
                            }
                        },
                        {
                            "metascore": 88,
                            "url": "https://www.metacritic.com/game/xbox-series-x/hogwarts-legacy",
                            "platform": {
                                "platform": 186,
                                "name": "Xbox Series S/X",
                                "slug": "xbox-series-x"
                            }
                        }
                    ],
                    "released": "2023-02-10",
                    "tba": false,
                    "updated": "2023-04-05T18:15:20",
                    "background_image": "https://media.rawg.io/media/games/044/044b2ee023930ca138deda151f40c18c.jpg",
                    "background_image_additional": "https://media.rawg.io/media/screenshots/810/810988f01c22b90bf086c7e9084cc22d.jpg",
                    "website": "https://www.hogwartslegacy.com/",
                    "rating": 4.05,
                    "rating_top": 5,
                    "ratings": [
                        {
                            "id": 5,
                            "title": "exceptional",
                            "count": 102,
                            "percent": 42.86
                        },
                        {
                            "id": 4,
                            "title": "recommended",
                            "count": 83,
                            "percent": 34.87
                        },
                        {
                            "id": 3,
                            "title": "meh",
                            "count": 34,
                            "percent": 14.29
                        },
                        {
                            "id": 1,
                            "title": "skip",
                            "count": 19,
                            "percent": 7.98
                        }
                    ],
                    "reactions": {
                        "1": 2,
                        "2": 2,
                        "3": 6,
                        "4": 1,
                        "5": 1,
                        "6": 1,
                        "7": 2,
                        "8": 1,
                        "9": 2,
                        "10": 2,
                        "11": 2,
                        "12": 2,
                        "14": 1,
                        "15": 1,
                        "16": 1,
                        "21": 1
                    },
                    "added": 1491,
                    "added_by_status": {
                        "yet": 143,
                        "owned": 354,
                        "beaten": 181,
                        "toplay": 647,
                        "dropped": 33,
                        "playing": 133
                    },
                    "playtime": 22,
                    "screenshots_count": 10,
                    "movies_count": 0,
                    "creators_count": 5,
                    "achievements_count": 48,
                    "parent_achievements_count": 24,
                    "reddit_url": "https://www.reddit.com/r/HarryPotterGame/",
                    "reddit_name": "Hogwarts Legacy",
                    "reddit_description": "Hogwarts Legacy | Your one-stop wizard shop about all things Hogwarts Legacy! Feel free to join our subreddit Discord server here: https://discord.gg/harrypottergame",
                    "reddit_logo": "",
                    "reddit_count": 105,
                    "twitch_count": 126,
                    "youtube_count": 1000000,
                    "reviews_text_count": 12,
                    "ratings_count": 226,
                    "suggestions_count": 877,
                    "alternative_names": [],
                    "metacritic_url": "https://www.metacritic.com/game/xbox-series-x/hogwarts-legacy",
                    "parents_count": 0,
                    "additions_count": 0,
                    "game_series_count": 0,
                    "user_game": null,
                    "reviews_count": 238,
                    "saturated_color": "0f0f0f",
                    "dominant_color": "0f0f0f",
                    "parent_platforms": [
                        {
                            "platform": {
                                "id": 1,
                                "name": "PC",
                                "slug": "pc"
                            }
                        },
                        {
                            "platform": {
                                "id": 2,
                                "name": "PlayStation",
                                "slug": "playstation"
                            }
                        },
                        {
                            "platform": {
                                "id": 3,
                                "name": "Xbox",
                                "slug": "xbox"
                            }
                        },
                        {
                            "platform": {
                                "id": 7,
                                "name": "Nintendo",
                                "slug": "nintendo"
                            }
                        }
                    ],
                    "platforms": [
                        {
                            "platform": {
                                "id": 4,
                                "name": "PC",
                                "slug": "pc",
                                "image": null,
                                "year_end": null,
                                "year_start": null,
                                "games_count": 543435,
                                "image_background": "https://media.rawg.io/media/games/736/73619bd336c894d6941d926bfd563946.jpg"
                            },
                            "released_at": "2023-02-10",
                            "requirements": {
                                "minimum": "Minimi:\\nRichiede un processore e un sistema operativo a 64 bit\\nSistema operativo: 64-bit Windows 10\\nProcessore: Intel Core i5-6600 (3.3Ghz) or AMD Ryzen 5 1400 (3.2Ghz)\\nMemoria: 16 GB di RAM\\nScheda video: NVIDIA GeForce GTX 960 4GB or AMD Radeon RX 470 4GB\\nDirectX: Versione 12\\nMemoria: 85 GB di spazio disponibile\\nNote aggiuntive: SSD (Preferred), HDD (Supported), 720p/30 fps, Low Quality Settings",
                                "recommended": "Consigliati:\\nRichiede un processore e un sistema operativo a 64 bit\\nSistema operativo: 64-bit Windows 10\\nProcessore: Intel Core i7-8700 (3.2Ghz) or AMD Ryzen 5 3600 (3.6 Ghz)\\nMemoria: 16 GB di RAM\\nScheda video: NVIDIA GeForce 1080 Ti or AMD Radeon RX 5700 XT or INTEL Arc A770\\nDirectX: Versione 12\\nMemoria: 85 GB di spazio disponibile\\nNote aggiuntive: SSD, 1080p/60 fps, High Quality Settings"
                            }
                        },
                        {
                            "platform": {
                                "id": 187,
                                "name": "PlayStation 5",
                                "slug": "playstation5",
                                "image": null,
                                "year_end": null,
                                "year_start": 2020,
                                "games_count": 828,
                                "image_background": "https://media.rawg.io/media/games/34b/34b1f1850a1c06fd971bc6ab3ac0ce0e.jpg"
                            },
                            "released_at": "2023-02-10",
                            "requirements": {}
                        },
                        {
                            "platform": {
                                "id": 186,
                                "name": "Xbox Series S/X",
                                "slug": "xbox-series-x",
                                "image": null,
                                "year_end": null,
                                "year_start": 2020,
                                "games_count": 733,
                                "image_background": "https://media.rawg.io/media/games/121/1213f8b9b0a26307e672cf51f34882f8.jpg"
                            },
                            "released_at": "2023-02-10",
                            "requirements": {}
                        },
                        {
                            "platform": {
                                "id": 18,
                                "name": "PlayStation 4",
                                "slug": "playstation4",
                                "image": null,
                                "year_end": null,
                                "year_start": null,
                                "games_count": 6599,
                                "image_background": "https://media.rawg.io/media/games/fc1/fc1307a2774506b5bd65d7e8424664a7.jpg"
                            },
                            "released_at": "2023-02-10",
                            "requirements": {}
                        },
                        {
                            "platform": {
                                "id": 7,
                                "name": "Nintendo Switch",
                                "slug": "nintendo-switch",
                                "image": null,
                                "year_end": null,
                                "year_start": null,
                                "games_count": 5207,
                                "image_background": "https://media.rawg.io/media/games/5a4/5a44112251d70a25291cc33757220fce.jpg"
                            },
                            "released_at": "2023-02-10",
                            "requirements": {}
                        },
                        {
                            "platform": {
                                "id": 1,
                                "name": "Xbox One",
                                "slug": "xbox-one",
                                "image": null,
                                "year_end": null,
                                "year_start": null,
                                "games_count": 5491,
                                "image_background": "https://media.rawg.io/media/games/fc1/fc1307a2774506b5bd65d7e8424664a7.jpg"
                            },
                            "released_at": "2023-02-10",
                            "requirements": {}
                        }
                    ],
                    "stores": [
                        {
                            "id": 909301,
                            "url": "",
                            "store": {
                                "id": 11,
                                "name": "Epic Games",
                                "slug": "epic-games",
                                "domain": "epicgames.com",
                                "games_count": 1218,
                                "image_background": "https://media.rawg.io/media/games/951/951572a3dd1e42544bd39a5d5b42d234.jpg"
                            }
                        },
                        {
                            "id": 909300,
                            "url": "",
                            "store": {
                                "id": 3,
                                "name": "PlayStation Store",
                                "slug": "playstation-store",
                                "domain": "store.playstation.com",
                                "games_count": 7797,
                                "image_background": "https://media.rawg.io/media/games/328/3283617cb7d75d67257fc58339188742.jpg"
                            }
                        },
                        {
                            "id": 904755,
                            "url": "",
                            "store": {
                                "id": 1,
                                "name": "Steam",
                                "slug": "steam",
                                "domain": "store.steampowered.com",
                                "games_count": 73834,
                                "image_background": "https://media.rawg.io/media/games/942/9424d6bb763dc38d9378b488603c87fa.jpg"
                            }
                        },
                        {
                            "id": 904754,
                            "url": "",
                            "store": {
                                "id": 2,
                                "name": "Xbox Store",
                                "slug": "xbox-store",
                                "domain": "microsoft.com",
                                "games_count": 4756,
                                "image_background": "https://media.rawg.io/media/games/26d/26d4437715bee60138dab4a7c8c59c92.jpg"
                            }
                        }
                    ],
                    "developers": [
                        {
                            "id": 3751,
                            "name": "Avalanche Software",
                            "slug": "avalanche-software",
                            "games_count": 31,
                            "image_background": "https://media.rawg.io/media/screenshots/085/0856e1493adba4990ba60e894bb6ec2a.jpg"
                        },
                        {
                            "id": 207303,
                            "name": "Portkey Games",
                            "slug": "portkey-games",
                            "games_count": 1,
                            "image_background": "https://media.rawg.io/media/games/044/044b2ee023930ca138deda151f40c18c.jpg"
                        }
                    ],
                    "genres": [
                        {
                            "id": 4,
                            "name": "Action",
                            "slug": "action",
                            "games_count": 179726,
                            "image_background": "https://media.rawg.io/media/games/618/618c2031a07bbff6b4f611f10b6bcdbc.jpg"
                        },
                        {
                            "id": 5,
                            "name": "RPG",
                            "slug": "role-playing-games-rpg",
                            "games_count": 54373,
                            "image_background": "https://media.rawg.io/media/games/0fd/0fd84d36596a83ef2e5a35f63a072218.jpg"
                        }
                    ],
                    "tags": [
                        {
                            "id": 31,
                            "name": "Singleplayer",
                            "slug": "singleplayer",
                            "language": "eng",
                            "games_count": 212947,
                            "image_background": "https://media.rawg.io/media/games/d82/d82990b9c67ba0d2d09d4e6fa88885a7.jpg"
                        },
                        {
                            "id": 13,
                            "name": "Atmospheric",
                            "slug": "atmospheric",
                            "language": "eng",
                            "games_count": 30004,
                            "image_background": "https://media.rawg.io/media/games/4be/4be6a6ad0364751a96229c56bf69be59.jpg"
                        },
                        {
                            "id": 40849,
                            "name": "Steam Cloud",
                            "slug": "steam-cloud",
                            "language": "eng",
                            "games_count": 13723,
                            "image_background": "https://media.rawg.io/media/games/d1a/d1a2e99ade53494c6330a0ed945fe823.jpg"
                        },
                        {
                            "id": 42,
                            "name": "Great Soundtrack",
                            "slug": "great-soundtrack",
                            "language": "eng",
                            "games_count": 3232,
                            "image_background": "https://media.rawg.io/media/games/7cf/7cfc9220b401b7a300e409e539c9afd5.jpg"
                        },
                        {
                            "id": 24,
                            "name": "RPG",
                            "slug": "rpg",
                            "language": "eng",
                            "games_count": 16951,
                            "image_background": "https://media.rawg.io/media/games/15c/15c95a4915f88a3e89c821526afe05fc.jpg"
                        },
                        {
                            "id": 118,
                            "name": "Story Rich",
                            "slug": "story-rich",
                            "language": "eng",
                            "games_count": 18400,
                            "image_background": "https://media.rawg.io/media/games/d1a/d1a2e99ade53494c6330a0ed945fe823.jpg"
                        },
                        {
                            "id": 36,
                            "name": "Open World",
                            "slug": "open-world",
                            "language": "eng",
                            "games_count": 6314,
                            "image_background": "https://media.rawg.io/media/games/16b/16b1b7b36e2042d1128d5a3e852b3b2f.jpg"
                        },
                        {
                            "id": 149,
                            "name": "Third Person",
                            "slug": "third-person",
                            "language": "eng",
                            "games_count": 9464,
                            "image_background": "https://media.rawg.io/media/games/618/618c2031a07bbff6b4f611f10b6bcdbc.jpg"
                        },
                        {
                            "id": 64,
                            "name": "Fantasy",
                            "slug": "fantasy",
                            "language": "eng",
                            "games_count": 25046,
                            "image_background": "https://media.rawg.io/media/games/8d4/8d46786ca86b1d95f3dc7e700e2dc4dd.jpg"
                        },
                        {
                            "id": 6,
                            "name": "Exploration",
                            "slug": "exploration",
                            "language": "eng",
                            "games_count": 19522,
                            "image_background": "https://media.rawg.io/media/games/a3c/a3c529a12c896c0ef02db5b4741de2ba.jpg"
                        },
                        {
                            "id": 97,
                            "name": "Action RPG",
                            "slug": "action-rpg",
                            "language": "eng",
                            "games_count": 5847,
                            "image_background": "https://media.rawg.io/media/games/d0f/d0f91fe1d92332147e5db74e207cfc7a.jpg"
                        },
                        {
                            "id": 69,
                            "name": "Action-Adventure",
                            "slug": "action-adventure",
                            "language": "eng",
                            "games_count": 13748,
                            "image_background": "https://media.rawg.io/media/games/e1f/e1ffbeb1bac25b19749ad285ca29e158.jpg"
                        },
                        {
                            "id": 41,
                            "name": "Dark",
                            "slug": "dark",
                            "language": "eng",
                            "games_count": 14525,
                            "image_background": "https://media.rawg.io/media/games/120/1201a40e4364557b124392ee50317b99.jpg"
                        },
                        {
                            "id": 107,
                            "name": "Family Friendly",
                            "slug": "family-friendly",
                            "language": "eng",
                            "games_count": 4990,
                            "image_background": "https://media.rawg.io/media/games/ba9/ba9ad92b6d04825bd15a407c6059db94.jpg"
                        },
                        {
                            "id": 121,
                            "name": "Character Customization",
                            "slug": "character-customization",
                            "language": "eng",
                            "games_count": 3401,
                            "image_background": "https://media.rawg.io/media/games/10d/10d19e52e5e8415d16a4d344fe711874.jpg"
                        },
                        {
                            "id": 145,
                            "name": "Choices Matter",
                            "slug": "choices-matter",
                            "language": "eng",
                            "games_count": 3333,
                            "image_background": "https://media.rawg.io/media/games/264/2642b17a7885f7abc4fd018e98943242.jpg"
                        },
                        {
                            "id": 82,
                            "name": "Magic",
                            "slug": "magic",
                            "language": "eng",
                            "games_count": 8158,
                            "image_background": "https://media.rawg.io/media/games/417/4176298c1b22ccd338ce3dfc34eb7e28.jpg"
                        },
                        {
                            "id": 1465,
                            "name": "combat",
                            "slug": "combat",
                            "language": "eng",
                            "games_count": 9092,
                            "image_background": "https://media.rawg.io/media/games/73d/73db43df633477d4604c7248292f34b2.jpg"
                        },
                        {
                            "id": 406,
                            "name": "Story",
                            "slug": "story",
                            "language": "eng",
                            "games_count": 11595,
                            "image_background": "https://media.rawg.io/media/games/4fe/4feffcec6315c5f5a96442a8444431ca.jpg"
                        },
                        {
                            "id": 413,
                            "name": "online",
                            "slug": "online",
                            "language": "eng",
                            "games_count": 6651,
                            "image_background": "https://media.rawg.io/media/screenshots/bf9/bf987c6a9734996d3be6838357d369b2.jpg"
                        },
                        {
                            "id": 981,
                            "name": "battle",
                            "slug": "battle",
                            "language": "eng",
                            "games_count": 10636,
                            "image_background": "https://media.rawg.io/media/games/6b1/6b14dc4cc1785e396580c69165e55d2d.jpg"
                        },
                        {
                            "id": 808,
                            "name": "character",
                            "slug": "character",
                            "language": "eng",
                            "games_count": 9016,
                            "image_background": "https://media.rawg.io/media/games/907/90757eaa9dc7c5cf7c47bf4960843999.jpg"
                        },
                        {
                            "id": 744,
                            "name": "friends",
                            "slug": "friends",
                            "language": "eng",
                            "games_count": 15237,
                            "image_background": "https://media.rawg.io/media/games/278/27873379c6d27b968babbeefa9b44da3.jpg"
                        },
                        {
                            "id": 2326,
                            "name": "explore",
                            "slug": "explore",
                            "language": "eng",
                            "games_count": 3295,
                            "image_background": "https://media.rawg.io/media/games/f87/f87de0e93f02007fd044e4bf04d453d8.jpg"
                        },
                        {
                            "id": 820,
                            "name": "secrets",
                            "slug": "secrets",
                            "language": "eng",
                            "games_count": 3352,
                            "image_background": "https://media.rawg.io/media/screenshots/8ec/8ece4995d49eab2c9771546fdd48388d.jpg"
                        },
                        {
                            "id": 2232,
                            "name": "journey",
                            "slug": "journey",
                            "language": "eng",
                            "games_count": 1908,
                            "image_background": "https://media.rawg.io/media/screenshots/fbe/fbe0636ae090cdf40ef074896466bd8b.jpg"
                        },
                        {
                            "id": 992,
                            "name": "student",
                            "slug": "student",
                            "language": "eng",
                            "games_count": 1572,
                            "image_background": "https://media.rawg.io/media/games/11a/11a4b86d38c877c6ffbf915547388d01.jpg"
                        },
                        {
                            "id": 712,
                            "name": "school",
                            "slug": "school",
                            "language": "eng",
                            "games_count": 4769,
                            "image_background": "https://media.rawg.io/media/games/24d/24d7163164c078e49f4c7e45e55fdf9e.jpg"
                        },
                        {
                            "id": 2006,
                            "name": "castle",
                            "slug": "castle",
                            "language": "eng",
                            "games_count": 1554,
                            "image_background": "https://media.rawg.io/media/screenshots/e8c/e8cc165f42c87b15ff5497e3fbaa37f9.jpg"
                        },
                        {
                            "id": 5506,
                            "name": "wizards",
                            "slug": "wizards",
                            "language": "eng",
                            "games_count": 1089,
                            "image_background": "https://media.rawg.io/media/screenshots/bd0/bd0ae747540a2b38740eb5f59c284a81.jpg"
                        },
                        {
                            "id": 71763,
                            "name": "Giocatore singolo",
                            "slug": "giocatore-singolo-2",
                            "language": "eng",
                            "games_count": 3,
                            "image_background": "https://media.rawg.io/media/games/044/044b2ee023930ca138deda151f40c18c.jpg"
                        },
                        {
                            "id": 930,
                            "name": "witch",
                            "slug": "witch",
                            "language": "eng",
                            "games_count": 1087,
                            "image_background": "https://media.rawg.io/media/screenshots/95e/95e31b355f4bd4c12e0eb0f1e9e0bf55.jpg"
                        },
                        {
                            "id": 71769,
                            "name": "Supporto completo per i controller",
                            "slug": "supporto-completo-per-i-controller",
                            "language": "eng",
                            "games_count": 2,
                            "image_background": "https://media.rawg.io/media/games/044/044b2ee023930ca138deda151f40c18c.jpg"
                        },
                        {
                            "id": 71768,
                            "name": "Achievement di Steam",
                            "slug": "achievement-di-steam",
                            "language": "eng",
                            "games_count": 2,
                            "image_background": "https://media.rawg.io/media/games/326/326cbbdc3bc2da0b10cc3f7edd57161a.jpg"
                        },
                        {
                            "id": 88361,
                            "name": "Дети",
                            "slug": "deti",
                            "language": "eng",
                            "games_count": 94,
                            "image_background": "https://media.rawg.io/media/screenshots/41e/41e0840035e9ae9ddb2f4692eab7980f.jpg"
                        },
                        {
                            "id": 6752,
                            "name": "potions",
                            "slug": "potions",
                            "language": "eng",
                            "games_count": 155,
                            "image_background": "https://media.rawg.io/media/screenshots/2ad/2ad07e28df7eba73557f067dbe255367.jpg"
                        },
                        {
                            "id": 16105,
                            "name": "character-creation",
                            "slug": "character-creation",
                            "language": "eng",
                            "games_count": 10,
                            "image_background": "https://media.rawg.io/media/screenshots/926/926ef20a40f1024c4cc5042fb029b00a.jpg"
                        },
                        {
                            "id": 88999,
                            "name": "Acquisti dall'applicazione",
                            "slug": "acquisti-dallapplicazione",
                            "language": "eng",
                            "games_count": 1,
                            "image_background": "https://media.rawg.io/media/games/044/044b2ee023930ca138deda151f40c18c.jpg"
                        },
                        {
                            "id": 38557,
                            "name": "character-generator",
                            "slug": "character-generator",
                            "language": "eng",
                            "games_count": 4,
                            "image_background": "https://media.rawg.io/media/screenshots/30b/30bbf804370331c27fa5f8ef4b5f4657.jpg"
                        }
                    ],
                    "publishers": [
                        {
                            "id": 350,
                            "name": "Warner Bros. Interactive",
                            "slug": "warner-bros-interactive",
                            "games_count": 204,
                            "image_background": "https://media.rawg.io/media/games/aa3/aa36ba4b486a03ddfaef274fb4f5afd4.jpg"
                        },
                        {
                            "id": 44545,
                            "name": "Wizarding World",
                            "slug": "wizarding-world",
                            "games_count": 1,
                            "image_background": "https://media.rawg.io/media/games/044/044b2ee023930ca138deda151f40c18c.jpg"
                        }
                    ],
                    "esrb_rating": {
                        "id": 3,
                        "name": "Teen",
                        "slug": "teen"
                    },
                    "clip": null,
                    "description_raw": "Hogwarts Legacy is an immersive, open-world action RPG set in the world first introduced in the Harry Potter books. Now you can take control of the action and be at the center of your own adventure in the wizarding world. Embark on a journey through familiar and new locations as you explore and discover fantastic beasts, customize your character and craft potions, master spell casting, upgrade talents, and become the wizard you want to be.\\r\\n\\r\\nExperience Hogwarts in the 1800s. Your character is a student who holds the key to an ancient secret that threatens to tear the wizarding world apart. You have received a late acceptance to the Hogwarts School of Witchcraft and Wizardry and soon discover that you are no ordinary student: you possess an unusual ability to perceive and master Ancient Magic. Only you can decide if you will protect this secret for the good of all, or yield to the temptation of more sinister magic.\\r\\n\\r\\nDiscover the feeling of living at Hogwarts as you make allies, battle Dark wizards, and ultimately decide the fate of the wizarding world. Your legacy is what you make of it."
                }
                """;
        GameCardDetailsModel model = objectMapper.readValue(text, GameCardDetailsModel.class);
        assertEquals("PC", model.platforms().get(0).name());
    }

    @Test
    void format() throws JsonProcessingException {
        GameCardDetailsModel model = new GameCardDetailsModel(
                1,
                "Day of the Tentacle",
                "Great game",
                "1991-01-01",
                Arrays.asList(new Publisher(1, "Lucas Arts")),
                Arrays.asList(new Genre(1, "Text adventure")),
                "lol",
                1,
                Arrays.asList(new Platform(1, "PC"), new Platform(2, "Mac"))
        );
        String text = objectMapper.writeValueAsString(model);
        assertEquals("""
                {
                  "id" : 1,
                  "title" : "Day of the Tentacle",
                  "description" : "Great game",
                  "releaseDate" : "1991-01-01",
                  "publishers" : [ {
                    "id" : 1,
                    "name" : "Lucas Arts"
                  } ],
                  "genres" : [ {
                    "id" : 1,
                    "name" : "Text adventure"
                  } ],
                  "cover" : "lol",
                  "rating" : 1,
                  "platforms" : [ {
                    "id" : 1,
                    "name" : "PC"
                  }, {
                    "id" : 2,
                    "name" : "Mac"
                  } ]
                }
                """.replaceAll("\\s", ""), text.replaceAll("\\s", ""));
    }


}