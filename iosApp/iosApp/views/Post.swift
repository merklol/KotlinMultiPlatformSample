import SwiftUI

struct Post: View {
    var title: String
    var content: String
    
    var body: some View {
        VStack(alignment: .leading) {
            Text(title).fontWeight(.bold).font(.system(size: 16))
            Text(content).font(.system(size: 14))
        }
    }
}
