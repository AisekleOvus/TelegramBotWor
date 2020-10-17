# TelegramBotWork
## TBWork

For now `sendPhoto` methods set complete

`public String sendPhoto(String photoUrl, String caption, String parse_mode, boolean disable_notification, int reply_to_message_id)`
 * **String photoUrl**   - defines url of image should be send, **parameter is required**
 * **String caption**    - defines a caption of image, if you want add some. **Optional parameter**
 * **String parse_mode** - Mode for parsing entities in the photo caption. See [formatting options](https://core.telegram.org/bots/api#formatting-options) for more details. **Optional parameter**
 * **boolean disable_notification** - Sends the message silently. Users will receive a notification with no sound. **Optional parameter**
 * **int reply_to_message_id**      - If the message is a reply, ID of the original message. **Optional parameter**

`public String sendPhotoParamsInLine(String params)`
* **String params** - use it if you have all the params in one line already. It must looks like set of *"&key=value"*.  
`public String sendPhoto(Map<String, String> params)`
* **Map<String, String> params** - you have a *Map<String key, String value>* containing params, use it.
