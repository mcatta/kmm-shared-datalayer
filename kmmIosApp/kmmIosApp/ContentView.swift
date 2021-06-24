import SwiftUI
import kmmShared

struct ContentView: View {
    let repository = GithubApiSource(
        httpClient: SharedHttpClient(),
        repositoryMapper: RepositoryMapper()
    )
    
    @State private var result: Result<[Repository],Error>?
    
	var body: some View {
        switch result {
        case .success(let repositories):
            ForEach(repositories) { repo in
                Text(repo.name)
            }
        
        default:
            Text("Loading")
                .onAppear(perform: loadRepositories)
        }
	}
    
    func loadRepositories() {
        repository.getRepositoriesByName(name: "mcatta") { response, error in
            print("Response: \(response)")
            print("Error: \(error)")
            
            self.result = .success(response ?? [])
        }
    }
}

extension Repository: Identifiable { }


struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView()
	}
}
